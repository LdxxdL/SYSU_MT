var movie = require('../models/Movie');
var cinema = require('../models/Cinema');
var webCtrol = {
}

webCtrol.index = function(req, res){
  cinema.fetch(function(err, cinemas){
    movie.fetch(function(err, movies){
      if (err){
        console.log('查询异常');
      }else{
        res.render('index', { 
          title: 'Express' ,
          movies: movies,
          cinemas: cinemas
        });
      }
    });
  });
}

webCtrol.cinema = function(req, res) {
  cinema.fetch(function(err, cinemas){
    if (err){
      console.log('查询异常');
    }else{
      res.render('cinemas', { 
        title: 'Express' ,
        cinemas: cinemas
      });
    }
  });
}
module.exports = webCtrol