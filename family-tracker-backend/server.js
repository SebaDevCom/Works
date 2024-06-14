const express = require('express');
const app = express();
const bodyParser = require('body-parser');
const mongoose = require('mongoose');
const bcrypt = require('bcrypt');
const jwt = require('jsonwebtoken');

app.use(bodyParser.json());

mongoose.connect('mongodb://localhost/family_tracker', {
  // Estas opciones ya no son necesarias y se pueden eliminar
  // useNewUrlParser: true, 
  // useUnifiedTopology: true 
});

const User = mongoose.model('User', new mongoose.Schema({
  username: String,
  password: String,
  location: {
    lat: Number,
    lng: Number
  }
}));

// Ruta para la raíz
app.get('/', (req, res) => {
  res.send('Welcome to the Family Tracker API');
});

app.post('/register', async (req, res) => {
  const { username, password } = req.body;
  const hashedPassword = await bcrypt.hash(password, 10);
  const user = new User({ username, password: hashedPassword });
  await user.save();
  res.send('User registered');
});

app.post('/login', async (req, res) => {
  const { username, password } = req.body;
  const user = await User.findOne({ username });
  if (user && await bcrypt.compare(password, user.password)) {
    const token = jwt.sign({ username: user.username }, 'your_jwt_secret');
    res.json({ token });
  } else {
    res.send('Invalid credentials');
  }
});

const authMiddleware = (req, res, next) => {
  const token = req.headers['authorization'];
  if (token) {
    jwt.verify(token, 'your_jwt_secret', (err, user) => {
      if (err) return res.sendStatus(403);
      req.user = user;
      next();
    });
  } else {
    res.sendStatus(401);
  }
};

app.post('/update-location', authMiddleware, async (req, res) => {
  const { location } = req.body;
  await User.updateOne({ username: req.user.username }, { $set: { location } });
  res.send('Location updated');
});

app.get('/location/:username', async (req, res) => {
  const user = await User.findOne({ username: req.params.username });
  res.send(user.location);
});

app.listen(3000, () => {
  console.log('Server started on port 3000');
});
