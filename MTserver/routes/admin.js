var express = require('express');
var router = express.Router();
var adminControl = require('../control/adminCtrl');

/* GET movies listing. */
router.get('/movie', adminControl.movieList);
router.get('/movietest', adminControl.testList);

/*movies add. */
router.route('/movie/add')
.get(adminControl.addMovie)
.post(adminControl.addMoviePost);

/*movies update. */
router.route('/movie/update')
.get(adminControl.updateMovie)
.post(adminControl.updateMoviePost);

/*movies delete */
router.post('/movie/delete', adminControl.deleteMovie);

/* GET cinema listing. */
router.get('/cinema', adminControl.cinemaList);
router.get('/movietest', adminControl.cinematestList);

/*cinemas add. */
router.route('/cinema/add')
.get(adminControl.addCinema)
.post(adminControl.addCinemaPost);

/*cinemas update. */
router.route('/cinema/update')
.get(adminControl.updateCinema)
.post(adminControl.updateCinemaPost);

/*cinemas delete */
router.post('/cinema/delete', adminControl.deleteCinema);

module.exports = router;
