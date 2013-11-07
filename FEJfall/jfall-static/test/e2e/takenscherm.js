'use strict';

describe('Toon taken', function () {

    beforeEach(function () {
        browser().navigateTo('/index.html#/takenlijst');
    });

    it('Gebruiker moet eerst inloggen', function () {
        expect(browser().location().url()).toBe('/login');
    });
});
