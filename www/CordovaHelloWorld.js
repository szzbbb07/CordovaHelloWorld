/**
 * cordova plugin
 * Copyright (c) ljx
 *
 */
 (function(cordova){
    var CordovaHelloWorld = function() {

    };  

    CordovaAlter.prototype.startConlose = function (success, fail) {
        return cordova.exec(function (args) {
            success(args);
        }, function (args) {
            fail(args);
        }, 'CordovaHelloWorld', 'startConlose', []);
    };


    CordovaAlter.prototype.startActivity = function (params, success, fail) {
        return cordova.exec(function(args) {
            success(args);
        }, function(args) {
            fail(args);
        }, 'CordovaHelloWorld', 'startActivity', [params]);
    };
 
    window.cordovaHelloWorld = new CordovaAlter();
    
    // backwards compatibility
    window.plugins = window.plugins || {};
    window.plugins.cordovaHelloWorld = window.cordovaHelloWorld;
})(window.PhoneGap || window.Cordova || window.cordova);
