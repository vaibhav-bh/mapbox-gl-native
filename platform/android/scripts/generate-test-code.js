'use strict';

const fs = require('fs');
const ejs = require('ejs');

global.iff = function (condition, val) {
  return condition() ? val : "";
}

global.camelize = function (str) {
  return str.replace(/(?:^|-)(.)/g, function (_, x) {
    return x.toUpperCase();
  });
}

const appBasePath = 'platform/android/MapboxGLAndroidSDKTestApp/src/main/java/com/mapbox/mapboxsdk/testapp/activity';
const testBasePath = 'platform/android/MapboxGLAndroidSDKTestApp/src/androidTest/java/com/mapbox/mapboxsdk/activity/';
const subPackages = fs.readdirSync(appBasePath);
const ejsConversionTask = ejs.compile(fs.readFileSync('platform/android/MapboxGLAndroidSDKTestApp/src/androidTest/java/com/mapbox/mapboxsdk/activity/activity.junit.ejs', 'utf8'), {strict: true});

for(const subPackage of subPackages) {
  if(!(subPackage.slice(-5) == '.java')) {
    const activities = fs.readdirSync(appBasePath+'/'+subPackage);

    if (!fs.existsSync(testBasePath+"/"+subPackage)){
        fs.mkdirSync(testBasePath+"/"+subPackage);
    }

    for (const activity of activities) {
      const activityName = activity.slice(0, -5);
      fs.writeFileSync(testBasePath+"/"+subPackage+"/"+activityName+'Test.java', ejsConversionTask([activityName, subPackage]));
    }
  }
}

