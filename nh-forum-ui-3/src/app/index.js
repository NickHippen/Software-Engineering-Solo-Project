import Post from './post';

import app from './app.component';

export default angular.module('nhForumUi.app', [
  Post
])
.component('app', app)
.name;
