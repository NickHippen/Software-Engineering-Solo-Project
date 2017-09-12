import Post from './post';

import app from './app.component';
import AppService from './app.service';

export default angular.module('nhForumUi.app', [
  Post
])
.component('app', app)
.service('AppService', AppService)
.name;
