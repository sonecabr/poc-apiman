//mongo
var Mongoose = require('mongoose');
var Schema = Mongoose.Schema;
Mongoose.connect('mongodb://client:changeme@localhost:27017/pocapimanclient');

module.exports = Mongoose;
