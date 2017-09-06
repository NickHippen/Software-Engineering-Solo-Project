import mainCtrl from 'components/main/main-controller';

describe('Main controller', () => {
    let ctrl;
    let scope;

    beforeEach(angular.mock.module('nh-forum-ui'));

    beforeEach(inject(($controller, $rootScope) => {
        scope = $rootScope.$new();

        ctrl = $controller(mainCtrl, {
            $scope: scope
        });
    }));

    it('should set application name on controller', () => {
        expect(ctrl.applicationName).toEqual('nh-forum-ui')
    });
});
