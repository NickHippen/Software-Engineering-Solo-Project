/**
 *  Entrance of common service
 *
 *
 *  @author  Nick Hippen
 *  @date    Sep 11, 2017
 *
 */
import components from './components/main';
import directives from './directives/main';
import runners from './runners/main';
import filters from './filters/main';

export default [...components, ...runners, ...directives, ...filters];
