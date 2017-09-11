/**
 *  Collection of Event helpers
 *
 *  @author  Nick Hippen
 *  @date    Sep 11, 2017
 *
 */
export function stop(e) {
    if (e.stopPropagation) {
        e.stopPropagation();
    }
    if (e.preventDefault) {
        e.preventDefault();
    }
}
