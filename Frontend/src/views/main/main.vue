<template>
  <el-container>
    <el-header>
      <span>电信结算系统</span>
    </el-header>
    <el-container>
      <el-aside>
        <el-menu
          default-active="2"
          background-color="#343f51"
          text-color="#eee"
          active-text-color="#ffffff">
          <el-submenu :index=index1 :key="index1" v-for="(feature,index1) in features">
            <template slot="title">
              <span>{{feature.title}}</span>
            </template>
            <el-menu-item v-for="(story,index2) in feature.stories" :key="index2">{{story.title}}</el-menu-item>
          </el-submenu>
        </el-menu>
      </el-aside>
      <el-main>Main</el-main>
    </el-container>
  </el-container>
</template>

<script>
  export default {
    name: "main",
    data() {
      return {
        features: [
          {
            title: '手工收入录入',
            stories: [
              {
                title: '出账收入录入',
                path: ''
              }, {
                title: '卡销售收入录入',
                path: ''
              }, {
                title: '预转存收入录入',
                path: ''
              }, {
                title: '网间结算收入录入',
                path: ''
              }, {
                title: '通知单收入录入',
                path: ''
              }
            ]
          }, {
            title: '数据收集',
            stories: [
              {
                title: '出账收入收集',
                path: ''
              }, {
                title: '卡销售收入收集',
                path: ''
              }, {
                title: '预转存收入收集',
                path: ''
              }, {
                title: '网间结算收入收集',
                path: ''
              }, {
                title: '通知单收入收集',
                path: ''
              }
            ]
          }, {
            title: '收款稽核',
            stories: [
              {
                title: '出账收入稽核',
                path: ''
              }, {
                title: '卡销售收入稽核',
                path: ''
              }, {
                title: '预转存收入稽核',
                path: ''
              }, {
                title: '网间结算收入稽核',
                path: ''
              }, {
                title: '通知单收入稽核',
                path: ''
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
    line-height: 160px;
  }

  .el-container {
    /*margin-bottom: 40px;*/
    display: flex;
    height: 100%;
    width: 100%;
    /*border: 1px solid #eee;*/
  }
</style>
