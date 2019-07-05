(function(){
	//需要向外暴露的 插件对象
	const MyPlugin={}
	MyPlugin.install=function(Vue,options){
		//添加全局方法或属性
		Vue.myGlobalMethod=function(){
			console.log("全局的方法")
		}
		
		//添加全局资源
		
		
		 Vue.directive("directive-text",function(el,binding){
			console.log(el,binding)
			el.textContent=binding.value.toUpperCase()
		})
		
		//添加实例方法
		Vue.prototype.$myMethod=function(){
			console.log("我是Vue实例对象的方法")
			
		}
		
	}
	//向外暴露
	window.MyPlugin = MyPlugin
})()