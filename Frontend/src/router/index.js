import Vue from 'vue'
import Router from 'vue-router'
import center from '../views/main/center'
import checkAccount from "../views/main/chequesAudit/checkAccount";
import checkCardSaling from "../views/main/chequesAudit/checkCardSaling";
import checkInternet from "../views/main/chequesAudit/checkInternet";
import checkNotice from "../views/main/chequesAudit/checkNotice";
import checkTransfers from "../views/main/chequesAudit/checkTransfers";
import manageAccount from "../views/main/dataManage/manageAccount";
import manageCardSaling from "../views/main/dataManage/manageCardSaling";
import manageInternet from "../views/main/dataManage/manageInternet";
import manageNotice from "../views/main/dataManage/manageNotice";
import manageTransfers from "../views/main/dataManage/manageTransfers";
import inputAccount from "../views/main/manualInput/inputAccount";
import inputCardSaling from "../views/main/manualInput/inputCardSaling";
import inputInternet from "../views/main/manualInput/inputInternet";
import inputNotice from "../views/main/manualInput/inputNotice";
import inputTransfers from "../views/main/manualInput/inputTransfers";
import userInfo from "../views/main/userInfo/userInfo";
import login from "../views/auth/login";

Vue.use(Router)

const originalPush = Router.prototype.push
Router.prototype.push = function push(location) {
  return originalPush.call(this, location).catch(err => err)
}


let router = new Router({
  routes: [
    {
      path: '/',
      name: 'login',
      component: login
    },
    {
      path: '/center',
      name: 'center',
      component: center,
      redirect: '/userInfo',
      meta: {
        auth: [0, 1, 2, 3, 4, 5, 6, 7]
      },
      children: [
        {
          path: '/userInfo',
          name: 'userInfo',
          component: userInfo,
          meta: {
            auth: [0, 1, 2, 3, 4, 5, 6, 7]
          },
        },
        {
          path: '/checkAudit/checkAccount',
          name: 'checkAccount',
          component: checkAccount,
          meta: {
            auth: [2, 4, 5, 7]
          }
        },
        {
          path: '/checkAudit/checkCardSaling',
          name: 'checkCardSaling',
          component: checkCardSaling,
          meta: {
            auth: [2, 4, 5, 7]
          }
        },
        {
          path: '/checkAudit/checkInternet',
          name: 'checkInternet',
          component: checkInternet,
          meta: {
            auth: [2, 4, 5, 7]
          }
        },
        {
          path: '/checkAudit/checkNotice',
          name: 'checkNotice',
          component: checkNotice,
          meta: {
            auth: [2, 4, 5, 7]
          }
        },
        {
          path: '/checkAudit/checkTransfers',
          name: 'checkTransfers',
          component: checkTransfers,
          meta: {
            auth: [2, 4, 5, 7]
          }
        },
        {
          path: '/dataManage/manageAccount',
          name: 'manageAccount',
          component: manageAccount,
          meta: {
            auth: [3, 5, 6, 7]
          }
        },
        {
          path: '/dataManage/manageCardSaling',
          name: 'manageCardSaling',
          component: manageCardSaling,
          meta: {
            auth: [3, 5, 6, 7]
          }
        },
        {
          path: '/dataManage/manageInternet',
          name: 'manageInternet',
          component: manageInternet,
          meta: {
            auth: [3, 5, 6, 7]
          }
        },
        {
          path: '/dataManage/manageNotice',
          name: 'manageNotice',
          component: manageNotice,
          meta: {
            auth: [3, 5, 6, 7]
          }
        },
        {
          path: '/dataManage/manageTransfers',
          name: 'manageTransfers',
          component: manageTransfers,
          meta: {
            auth: [3, 5, 6, 7]
          }
        },
        {
          path: '/manualInput/inputAccount',
          name: 'inputAccount',
          component: inputAccount,
          meta: {
            auth: [1, 4, 6, 7]
          }
        },
        {
          path: '/manualInput/inputCardSaling',
          name: 'inputCardSaling',
          component: inputCardSaling,
          meta: {
            auth: [1, 4, 6, 7]
          }
        },
        {
          path: '/manualInput/inputInternet',
          name: 'inputInternet',
          component: inputInternet,
          meta: {
            auth: [1, 4, 6, 7]
          }
        },
        {
          path: '/manualInput/inputNotice',
          name: 'inputNotice',
          component: inputNotice,
          meta: {
            auth: [1, 4, 6, 7]
          }
        },
        {
          path: '/manualInput/inputTransfers',
          name: 'inputTransfers',
          component: inputTransfers,
          meta: {
            auth: [1, 4, 6, 7]
          }
        },
      ]
    },
  ]
})

//路由守卫
router.beforeEach((to, from, next) => {
  if (to.path !== '/') {
    if (sessionStorage.user && to.meta.auth.includes(parseInt(sessionStorage.auth))) {
      next()
    } else {
      next({
        path: '/',
        query: {
          redirect: to.fullPath
        }
      })
    }
  } else {
    next()
  }
})


export default router;
