<template>
  <el-container>
    <el-header>
      <span class="title">电信结算系统</span>
      <el-dropdown class="nav">
        <span class="el-dropdown-link">{{user}}<i class="el-icon-arrow-down el-icon--right"></i></span>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item>
            <router-link to="/userInfo">个人信息</router-link>
          </el-dropdown-item>
          <el-dropdown-item>
            <router-link :to="{name: 'login'}">退出登录</router-link>
          </el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
    </el-header>
    <el-container>
      <el-aside>
        <el-menu
          :router="true"
          default-active="2"
          background-color="#343f51"
          text-color="#eee"
          active-text-color="#ffffff">
          <el-submenu v-if="auth(feature.auth)" :index="index1+''" :key="index1"
                      v-for="(feature,index1) in features">
            <template slot="title">
              <span>{{feature.title}}</span>
            </template>
            <el-menu-item :index="story.path" v-for="(story,index2) in feature.stories" :key="index2">{{story.title}}
            </el-menu-item>
          </el-submenu>
        </el-menu>
      </el-aside>
      <el-main>
        <router-view/>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
  export default {
    name: "center",
    data() {
      return {
        user: '王大锤',
        features: [
          {
            title: '手工收入录入',
            auth: [1, 4, 6, 7],
            stories: [
              {
                title: '出账收入',
                path: '/manualInput/inputAccount'
              }, {
                title: '卡销售收入',
                path: '/manualInput/inputCardSaling'
              }, {
                title: '预转存收入',
                path: '/manualInput/inputTransfers'
              }, {
                title: '网间结算收入',
                path: '/manualInput/inputInternet'
              }, {
                title: '通知单收入',
                path: '/manualInput/inputNotice'
              }
            ]
          }, {
            title: '收款稽核',
            auth: [2, 4, 5, 7],
            stories: [
              {
                title: '出账收入',
                path: '/checkAudit/checkAccount'
              }, {
                title: '卡销售收入',
                path: '/checkAudit/checkCardSaling'
              }, {
                title: '预转存收入',
                path: '/checkAudit/checkTransfers'
              }, {
                title: '网间结算收入',
                path: '/checkAudit/checkInternet'
              }, {
                title: '通知单收入',
                path: '/checkAudit/checkNotice'
              }
            ]
          }, {
            title: '数据归集',
            auth: [3, 5, 6, 7],
            stories: [
              {
                title: '出账收入',
                path: '/dataManage/manageAccount'
              }, {
                title: '卡销售收入',
                path: '/dataManage/manageCardSaling'
              }, {
                title: '预转存收入',
                path: '/dataManage/manageTransfers'
              }, {
                title: '网间结算收入',
                path: '/dataManage/manageInternet'
              }, {
                title: '通知单收入',
                path: '/dataManage/manageNotice'
              }
            ]
          }
        ]
      }
    },
    methods: {
      auth(arr) {
        return arr.includes(parseInt(sessionStorage.auth));
      }
    }
  }
</script>

<style lang="scss" scoped>
  .el-header {
    background-color: #1a2f4d;
    box-shadow: 0 0 5px #333333;
    position: relative;
    color: #e9eef2;
    /*text-align: center;*/
    line-height: 60px;
    height: 60px;

    .title {
      position: absolute;
      left: auto;
      font-size: 20px;
    }

    .nav {
      position: absolute;
      right: 20px;
      color: #e9eef2;
      font-size: 16px;
    }
  }

  .el-aside {
    background-color: #343f51;
    color: #333;
    flex: 1;
    /*text-align: center;*/
    /*line-height: 200px;*/
  }

  .el-main {
    background-color: #E9EEF3;
    color: #333;
    flex: 4;
    text-align: center;
    /*line-height: 160px;*/
  }

  .el-container {
    /*margin-bottom: 40px;*/
    display: flex;
    height: 100%;
    width: 100%;
    /*border: 1px solid #eee;*/
  }
</style>
