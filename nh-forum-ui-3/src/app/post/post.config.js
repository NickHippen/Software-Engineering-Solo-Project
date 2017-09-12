export default function routesConfig($stateProvider) {
  'ngInject';

  $stateProvider
    .state('post', {
      url: '/post',
      component: 'post'
    });
}
