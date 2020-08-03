<template>
  <el-container>
    <el-header>
      <span>电信结算系统</span>
    </el-header>
    <el-container>
      <el-aside>
        <el-menu
          :router="true"
          default-active="2"
          background-color="#343f51"
          text-color="#eee"
          active-text-color="#ffffff">
          <el-menu-item index="/userInfo">用户中心</el-menu-item>
          <el-submenu :index="index1+''" :key="index1" v-for="(feature,index1) in features">
            <template slot="title">
              <span>{{feature.title}}</span>
            </template>
            <el-menu-item :index="story.path" v-for="(story,index2) in feature.stories" :key="index2">{{story.title}}</el-menu-item>
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
        features: [
          {
            title: '手工收入录入',
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
    methods: {}
  }
</script>

<style lang="scss" scoped>
  .el-header {
    background-color: #1a2f4d;
    box-shadow: 0px 0px 5px #333333;
    color: #ffffff;
    /*text-align: center;*/
    line-height: 60px;
    height: 60px;
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
