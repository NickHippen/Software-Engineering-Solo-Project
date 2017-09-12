/**
 *  Defines the HomeService
 *
 *  @author  Nick Hippen
 *  @date    Sep 11, 2017
 *
 */

import '../../common/constants/rest-server';
export default class {

    /*@ngInject*/
    constructor($http) {
        this.$http = $http;
    }

    getForumPosts() {
        return this.$http({
            method: 'POST',
            url: 'http://localhost:8080/nh-forum-rest/ForumPosts'
        });
    }
}
