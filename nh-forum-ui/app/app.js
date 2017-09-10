import 'jquery';
import angular from 'angular';
import 'angular-resource';
import 'angular-ui-router';
import 'angular-sanitize';

import 'services/services';
import 'directives/directives';
import 'services/version-service';
import 'angular-ui-bootstrap';

import mainRoutes from 'components/main/main.routes';

angular.module('nh-forum-ui', ['ngResource', 'ui.router', 'services', 'directives', 'ngSanitize', 'version', 'ui.bootstrap'])

.config(mainRoutes);
