var express = require('express');
var router = express.Router();
var clientControl = require('../control/clientCtrl');

/* GET movies listing. */
router.get('/movielist', clientControl.movieList);
router.get('/movielist/details', clientControl.getDetails);
router.get('/movielist/:image', clientControl.getPic);
router.get('/movielist/find', clientControl.getMovieByName);
router.get('/cinema/movielist', clientControl.getMbyC);
router.get('/cinemalist', clientControl.cinemaList);

module.exports = router;
