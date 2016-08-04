var express = require('express');
var app = express();
var bodyParser = require('body-parser');
var userRoute = require('./app/routes/UserRoute.js');
var userTokenRoute = require('./app/routes/UserTokenRoute.js');


app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());

var port = process.env.PORT || 8000;

//default context
app.use('/user', userRoute);
app.use('/userToken', userTokenRoute);



//expose server
app.listen(port);
console.log('server started on port ' + port);