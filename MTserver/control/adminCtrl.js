var adminCtrol = {
}
var Movie = require('../models/Movie');
var Cinema = require('../models/Cinema');

// 查询电影列表（所有电影）
adminCtrol.movieList = function(req, res) {
  Movie.fetch(function(err, movies){
    if (err){
      console.log('查询异常');
    }else{
      res.render('admin/movie/movie_list', { 
        title: 'admin' ,
        movies: movies
      });
    }
  });
};


// 后台接口原数据显示(异步接口)
adminCtrol.testList = function(req, res) {
  Movie.fetch(function(err, movies){
    if (err){
      console.log('查询异常');
    }else{
      res.json(movies);
    }
  });
}

adminCtrol.addMovie = function(req, res) {
  res.render('admin/movie/movie_add', { title: 'admin' });
}
// 提交新增用户请求
adminCtrol.addMoviePost = function(req, res, next) {
  var movieObj = {};
  movieObj = {
    name: req.body.name,
    type: req.body.type,
    score: req.body.score,
    date: req.body.date,
    intro: req.body.intro,
    actor: req.body.actor,
    src: req.body.src
  };
  Movie.createInfo(movieObj, function(err, movie){
    if (err){
      console.log('新增用户信息错误');
    }else{
      if (movie && movie.name){
        res.redirect('/admin/movie');
      }
    }
  });
}

// 修改用户信息
adminCtrol.updateMovie = function(req, res) {
  var id = req.query.id;
  Movie.findById(id, function(err, movie){
    if (err){
      console.log('根据Id查找用户信息，出错');
    }else{
      res.render('admin/movie/movie_update', {
        title: 'admin',
        movie: movie
      });
    }
  });
}
adminCtrol.updateMoviePost = function(req, res) {
  var id = req.body.id;
  var movie = {
    name: req.body.name,
    type: req.body.type,
    score: req.body.score,
    date: req.body.date,
    intro: req.body.intro,
    actor: req.body.actor,
    src: req.body.src
  };
  Movie.updateInfo(id, movie, function(err, updateCount){
    if (err){
      console.log('更新用户信息，出错');
    }else{
      res.redirect('/admin/movie');
    }
  });
}

// 删除用户
adminCtrol.deleteMovie = function(req, res) {
  var id = req.body.id;
  Movie.deleteInfo(id, function(err, updateCount){
    if (err){
      res.json({error:err});
    }else{
      res.json({success: true});
    }
  });
}


/////////////////////////////////////////电影院
// 查询电影列表（所有电影）
adminCtrol.cinemaList = function(req, res) {
  Cinema.fetch(function(err, cinemas){
    if (err){
      console.log('查询异常');
    }else{
      res.render('admin/cinema/cinema_list', { 
        title: 'admin' ,
        cinemas: cinemas
      });
    }
  });
};

// 后台接口原数据显示(异步接口)
adminCtrol.cinematestList = function(req, res) {
  Cinema.fetch(function(err, cinemas){
    if (err){
      console.log('查询异常');
    }else{
      res.json(cinemas);
    }
  });
}

adminCtrol.addCinema = function(req, res) {
  res.render('admin/cinema/cinema_add', { title: 'admin' });
}
// 提交新增用户请求
adminCtrol.addCinemaPost = function(req, res, next) {
  var cinemaObj = {
    name: req.body.name,
    city: req.body.city,
    address: req.body.address,
    moviename: req.body.moviename
  };
  Cinema.createInfo(cinemaObj, function(err, cinema){
    if (err){
      console.log('新增用户信息错误');
    }else{
      if (cinema && cinema.name){
        res.redirect('/admin/cinema');
      }
    }
  });
}

// 修改用户信息
adminCtrol.updateCinema = function(req, res) {
  var id = req.query.id;
  Cinema.findById(id, function(err, cinema){
    if (err){
      console.log('根据Id查找用户信息，出错');
    }else{
      res.render('admin/cinema/cinema_update', {
        title: 'admin',
        cinema: cinema
      });
    }
  });
}
adminCtrol.updateCinemaPost = function(req, res) {
  var id = req.body.id;
  var cinema = {};
  cinema = {
    name: req.body.name,
    city: req.body.city,
    address: req.body.address,
    moviename: req.body.moviename
  };
  Cinema.updateInfo(id, cinema, function(err, updateCount){
    if (err){
      console.log('更新用户信息，出错');
    }else{
      res.redirect('/admin/cinema');
    }
  });
}

// 删除用户
adminCtrol.deleteCinema = function(req, res) {
  var id = req.body.id;
  Cinema.deleteInfo(id, function(err, updateCount){
    if (err){
      res.json({error:err});
    }else{
      res.json({success: true});
    }
  });
}
module.exports = adminCtrol