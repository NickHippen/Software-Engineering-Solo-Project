import angular from 'angular';
import 'angular-ui-router';

import routesConfig from './routes';

import Common from './common';
import App from './app';

import './index.scss';

export default angular.module('nhForumUi', [
  'ui.router',
  Common,
  App
])
.config(routesConfig)
.name;
