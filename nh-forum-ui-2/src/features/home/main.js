/**
 * ******************************************************************************************************
 *
 *   Defines a home feature
 *
 *  @author  Nick Hippen
 *  @date    Sep 11, 2017
 *
 * ******************************************************************************************************
 */
import routes from './routes';

import home from './components/home';
import logo from './components/subs/logo';
import description from './components/subs/description';
import github from './components/subs/github';
import todoApp from './components/subs/todo';
import footer from './components/subs/footer';

import HomeService from './service/HomeService';
import ForumService from './service/ForumService';

export default {
    type: 'feature',
    name: 'home',
    routes,
    component: {
        home,
        logo,
        description,
        github,
        todoApp,
        footer
    },
    service: {
        HomeService,
        ForumService
    }
};
