import createPostConfig from './create-post.config';

import createPost from './create-post.component';

export default angular.module('nhForumUi.app.createPost', [
])
.config(createPostConfig)
.component('createPost', createPost)
.name;
