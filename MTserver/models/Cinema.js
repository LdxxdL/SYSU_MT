var mongoose = require('mongoose');

var CinemaSchema = new mongoose.Schema({
  name: String,
  city: String,
  address: String,
  moviename: String,
  meta: {
    createAt: {
      type: Date,
      default: Date.now()
    },
    updateAt:{
      type: Date,
      default: Date.now()
    }
  }
});

CinemaSchema.pre('save', function(next){
  if (this.isNew){
    this.meta.createAt = this.meta.updateAt = Date.now();
  }else{
    this.meta.updateAt = Date.now();
  } 
  next();
})

CinemaSchema.statics = {
  fetch: function(cb){
    return this
      .find({})
      .sort({'name': 'asc'})
      .exec(cb);
  },
  findById: function(id, cb){
    return this
      .findOne({_id: id}).exec(cb);
  },
  createInfo: function(cinema, cb){
    return this
      .create(cinema, cb);
  },
  updateInfo: function(id, cinema, cb){
    var conditions = {_id: id};
    var options = {};
    var update = {$set: cinema};
    return this
      .update(conditions, update, options, cb);
  },
  deleteInfo: function(id, cb){
    var conditions = {_id: id};
    return this
      .remove(conditions, cb);
  }
};
var cinema = mongoose.model('cinemas', CinemaSchema);

module.exports = cinema