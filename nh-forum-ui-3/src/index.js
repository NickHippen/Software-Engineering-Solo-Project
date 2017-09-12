import angular from 'angular';
import 'angular-ui-router';

import routesConfig from './routes';

import App from './app';

import './index.scss';

export default angular.module('nhForumUi', [
  'ui.router',
  App
])
.config(routesConfig)
.name;
