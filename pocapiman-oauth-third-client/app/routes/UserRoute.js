var express = require('express');
var router = express.Router();
var User = require('../models/User.js');
var UserToken = require('../models/Usertoken.js');

router.use(function timeLog(req, res, next) {
  console.log('Time: ', Date.now());
  next();
});

router.get('/', function(req, res) {
    res.json({ message: 'Im working!' });
});

//User route
router.post('/', function(req, res){
    var user = new User();
    user.name = req.body.name;
    user.save(function(err){
        if(err){
            res.send(err);
        }
        res.json({message: "Created"});
    });
});

router.get('/:userId', function(req, res) {
     console.log('find user : ' + req.params.userId);
     User.findById(
        req.params.userId,
        function(err, user){
            if(err){
                console.info(err);
                res.status(404).send('Not Found');
            }
            res.send(user)
        }
     );
});


router.get('/list/full', function(req, res){
    console.log('Calling /user/list/full');
       User.find({}, function(err, users){
            if(err){
                console.info(err);
                res.status(404).send('Not Found');
            }
            res.send(users)
       });
});

module.exports = router;