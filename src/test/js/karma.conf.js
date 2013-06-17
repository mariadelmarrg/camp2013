// Karma configuration
// Generated on Thu May 09 2013 17:19:56 GMT+0100 (GMT Daylight Time)


// base path, that will be used to resolve files and exclude
basePath = '../../../';


// list of files / patterns to load in the browser
files = [
  JASMINE,
  JASMINE_ADAPTER,
  'src/test/js/lib/mocks.js',
  'src/test/js/lib/karma.js',
  'src/main/resources/assets/js/lib/jquery-*.js',
  'src/main/resources/assets/js/lib/angular.js',
  'src/main/resources/assets/js/lib/angular-*.js',
  'src/main/resources/assets/js/lib/underscore-min.js',
  //'src/main/resources/assets/js/lib/base64.js',
  'src/main/resources/assets/js/controller.js',
  'src/main/resources/assets/js/services.js',
  'src/test/js/lib/angular-mocks.js',
  'src/test/js/unit/*.js',
];

preprocessors = {
  'src/main/webapp/js/*.js' : 'coverage'
};

// list of files to exclude
exclude = [
  
];


// test results reporter to use
// possible values: 'dots', 'progress', 'junit'
reporters = ['dots', 'junit', 'coverage'];

coverageReporter = {
  type : 'html',
  dir : 'target/coverage/'
};

junitReporter = {
  outputFile: 'target/test-results.xml'
};

// web server port
port = 9876;


// cli runner port
runnerPort = 9100;


// enable / disable colors in the output (reporters and logs)
colors = true;


// level of logging
// possible values: LOG_DISABLE || LOG_ERROR || LOG_WARN || LOG_INFO || LOG_DEBUG
logLevel = LOG_INFO;


// enable / disable watching file and executing tests whenever any file changes
autoWatch = true;


// Start these browsers, currently available:
// - Chrome
// - ChromeCanary
// - Firefox
// - Opera
// - Safari (only Mac)
// - PhantomJS
// - IE (only Windows)
browsers = ['Chrome'];


// If browser does not capture in given timeout [ms], kill it
captureTimeout = 60000;


// Continuous Integration mode
// if true, it capture browsers, run tests and exit
singleRun = false;

