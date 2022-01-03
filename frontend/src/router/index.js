import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  },
  {
    path:'/hole/:id',
    name:'Hole',
    component:()=> import("../views/Hole.vue"),
  },
  {
    path:'/search',
    name:'Search',
    component:() => import("../views/Search.vue")
  },
  {
    //新建树洞的界面
    path:'/peckHole',
    name:'PeckHole',
    component:()=> import("../views/Submit.vue")
  },
  {
    //成功建立树洞之后的重定向
    path:'/redirect/:id',
    name:"Redirect",
    component:()=> import("../views/Redirect.vue")
  },
  {
    //成功建立树洞之后的重定向
    path:'/index',
    name:"Index",
    component:()=> import("../components/Index.vue")
  }
]

const router = new VueRouter({
  routes
})

export default router
