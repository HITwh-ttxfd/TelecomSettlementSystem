import Vue from 'vue'
import Router from 'vue-router'
import main from '../views/main/main'
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

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'login',
      // component: main,
      redirect: main
    },
    {
      path: '/main',
      name: 'main',
      component: main,
      children: [
        {
          path: '/checkAudit/checkAccount',
          name: 'checkAccount',
          component: checkAccount,
        },
        {
          path: '/checkAudit/checkCardSaling',
          name: 'checkCardSaling',
          component: checkCardSaling,
        },
        {
          path: '/checkAudit/checkInternet',
          name: 'checkInternet',
          component: checkInternet,
        },
        {
          path: '/checkAudit/checkNotice',
          name: 'checkNotice',
          component: checkNotice,
        },
        {
          path: '/checkAudit/checkTransfers',
          name: 'checkTransfers',
          component: checkTransfers,
        },
        {
          path: '/dataManage/manageAccount',
          name: 'manageAccount',
          component: manageAccount,
        },
        {
          path: '/dataManage/manageCardSaling',
          name: 'manageCardSaling',
          component: manageCardSaling,
        },
        {
          path: '/dataManage/manageInternet',
          name: 'manageInternet',
          component: manageInternet,
        },
        {
          path: '/dataManage/manageNotice',
          name: 'manageNotice',
          component: manageNotice,
        },
        {
          path: '/dataManage/manageTransfers',
          name: 'manageTransfers',
          component: manageTransfers,
        },
        {
          path: '/manualInput/inputAccount',
          name: 'inputAccount',
          component: inputAccount,
        },
        {
          path: '/manualInput/inputCardSaling',
          name: 'inputCardSaling',
          component: inputCardSaling,
        },
        {
          path: '/manualInput/inputInternet',
          name: 'inputInternet',
          component: inputInternet,
        },
        {
          path: '/manualInput/inputNotice',
          name: 'inputNotice',
          component: inputNotice,
        },
        {
          path: '/manualInput/inputTransfers',
          name: 'inputTransfers',
          component: inputTransfers,
        },
      ]
    },
  ]
})