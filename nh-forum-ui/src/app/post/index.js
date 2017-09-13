import postConfig from './post.config';

import post from './post.component';

import './post.scss';

export default angular.module('nhForumUi.app.post', [
])
.config(postConfig)
.component('post', post)
.name;
