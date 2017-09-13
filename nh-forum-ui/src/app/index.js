import Post from './post';
import CreatePost from './create-post';

import app from './app.component';
import AppService from './app.service';

export default angular.module('nhForumUi.app', [
  Post,
  CreatePost
])
.component('app', app)
.service('AppService', AppService)
.name;
