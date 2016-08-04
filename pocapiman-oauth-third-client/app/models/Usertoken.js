Mongoose = require('../config/Mongoose.js');
Schema  = Mongoose.Schema;

var UserToken = new Schema({
    id : String,
    name : String,
    password : String
});

module.exports = Mongoose.model('UserToken', UserToken);
