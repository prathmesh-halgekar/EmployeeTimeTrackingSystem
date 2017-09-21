/**
 * 
 */
var app = angular.module('timeTrack', []);

app.controller('homeCtrl', function($scope, $http) {
	$scope.message="user123";
	$scope.projects = ["Evo", "HBO"];	
	$scope.punchedIn = false;
	$scope.punchedOut = false;
	
	$scope.init = function(){
		console.log("init : start");
		$http.get("http://localhost:8080/welcomeData")
	    .then(function(response) {
	        $scope.message = response.data.message;
			console.log("init : end");
	    },function(error){
	    	console.log(error);
	    }); 
	   
	};
	$scope.init();
	
	/*punchIn()
	punchOut()
	breakStart()
	breakStop()*/
	
	$scope.punchIn = function(){
		console.log("init : start");
		var formData = new FormData();
		formData.append('projectId',$scope.selectedProject);
		$http.post("http://localhost:8080/storeInTime",formData)
	    .then(function(response) {
	        $scope.notifications = response.data.message;
	        $scope.punchedIn = true;
			console.log("init : end");
	    },function(error){
	    	console.log(error);
	    }); 
	   
	};
	$scope.punchOut = function(){
		console.log("init : start");
		var formData = new FormData();
		formData.append('projectId',$scope.selectedProject);
		$http.post("http://localhost:8080/storeOutTime",formData)
	    .then(function(response) {
	        $scope.notifications = response.data.message;
	        $scope.punchedOut = true;
			console.log("init : end");
	    },function(error){
	    	console.log(error);
	    }); 
	   
	};
	/*$scope.init = function(){
		var imageFile = document.getElementById('selectFile').files[0];
		var formData = new FormData();
		formData.append('imageFile',imageFile);
		console.log("inside upload"+imageFile);
		$http.post("http://localhost:8076/upload",formData,{
			   transformRequest: angular.identity,
			   headers: {'Content-Type': undefined}
			})
	    .then(function(response) {
	        $scope.myWelcome = response.data;
	        console.log("converted img : "+$scope.myWelcome);
			console.log("in success");
	    }); 
	   
	};*/
	
});