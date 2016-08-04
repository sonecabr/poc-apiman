Mongoose = require('../config/Mongoose.js');
Schema  = Mongoose.Schema;

var User = new Schema({
    id : String,
    name : String,
    password : String
});

module.exports = Mongoose.model('User', User);
