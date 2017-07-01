var clientCtrol = {
}

var Path = require('path');
var Movie = require('../models/Movie');
var Cinema = require('../models/Cinema');

//电影列表
clientCtrol.movieList = function(req, res) {
  Movie.fetch(function(err, movies){
    if (err){
      console.log('Error in getting movieList');
    }else{
      return res.json(movies);
    }
  });
};

//通过id获取图片名，评论，演员
clientCtrol.getDetails = function(req, res) {
   Movie.findById({id: req.query.id}, function(err, movie) {
    if (err) {
      console.log('ERROR IN FIND: ' + err);
    } else {
          return res.json({
          	src: movie.src,
          	intro: movie.intro,
          	actor: movie.actor
          });
        }
    });
};

//通过name获取电影
clientCtrol.getMovieByName = function(req, res) {
    Movie.findByName({name: req.params.name}, function(err, movie) {
      if (err) {
        console.log('Error in finding movie by name ' + err);
      }else {
        return res.json({
          movie: movie
        });
      }
    });
};

//根据图片名字发送相应图片给客户端
clientCtrol.getPic = function(req, res) {
    res.sendFile(Path.resolve(__dirname + '/../asset/image/' + req.params.src), function(err) {
      if (err) {
        console.log('Error in sending image: ' + err);
      } else {
        return console.log('SENDING IMAGE SUCCESSFULLY...');
      }
    });
};


clientCtrol.cinemaList = function(req, res) {
  Cinema.fetch(function(err, cinemas){
    if (err){
      console.log('Error in getting movieList');
    }else{
      return res.json(cinemas);
    }
  });
};

//通过电影院id返回电影id
clientCtrol.getMbyC = function(req, res) {

  Cinema.findById({id: req.query.id}, function(err, cinemas) {

    if (err) {
      console.log('Error in getting movie by cinema: ' + err);
    } else {
      return res.json ({
        moviename: cinemas.moviename
      });
    }
  });
}

module.exports = clientCtrol