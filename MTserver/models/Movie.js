var mongoose = require('mongoose');

var MovieSchema = new mongoose.Schema({
  name: String,
  type: String,
  score: String,
  date: String,
  intro: String,
  actor: String,
  src: String,
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

MovieSchema.pre('save', function(next){
  if (this.isNew){
    this.meta.createAt = this.meta.updateAt = Date.now();
  }else{
    this.meta.updateAt = Date.now();
  } 
  next();
})

MovieSchema.statics = {
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
  findByName: function(name, cb){
    return this
      .findOne({name: name}).exec(cb);
  },
  createInfo: function(movie, cb){
    return this
      .create(movie, cb);
  },
  updateInfo: function(id, movie, cb){
    var conditions = {_id: id};
    var options = {};
    var update = {$set: movie};
    return this
      .update(conditions, update, options, cb);
  },
  deleteInfo: function(id, cb){
    var conditions = {_id: id};
    return this
      .remove(conditions, cb);
  }
};
var movie = mongoose.model('movies', MovieSchema);

module.exports = movie