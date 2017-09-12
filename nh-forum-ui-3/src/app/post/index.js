import postConfig from './post.config';

import post from './post.component';

export default angular.module('nhForumUi.app.post', [
])
.config(postConfig)
.component('post', post)
.name;
