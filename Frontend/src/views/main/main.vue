<template>
  <el-container>
    <el-header>
      <span style="font-size: 30px">电信结算系统</span>
    </el-header>
    <el-container style="padding-top: 3px">
      <el-aside width="200px">
        <el-row class="tac">
          <el-col>
            <el-menu
              default-active="2"
              class="el-menu-vertical-demo"
              @open="handleOpen"
              @close="handleClose">
              <el-submenu index="1">
                <template slot="title">
                  <i class="el-icon-location"></i>
                  <span>导航一</span>
                </template>
                <el-menu-item-group>
                  <template slot="title">分组一</template>
                  <el-menu-item index="1-1">选项1</el-menu-item>
                  <el-menu-item index="1-2">选项2</el-menu-item>
                </el-menu-item-group>
                <el-menu-item-group title="分组2">
                  <el-menu-item index="1-3">选项3</el-menu-item>
                </el-menu-item-group>
                <el-submenu index="1-4">
                  <template slot="title">选项4</template>
                  <el-menu-item index="1-4-1">选项1</el-menu-item>
                </el-submenu>
              </el-submenu>
              <el-menu-item index="2">
                <i class="el-icon-menu"></i>
                <span slot="title">导航二</span>
              </el-menu-item>
              <el-menu-item index="3" disabled>
                <i class="el-icon-document"></i>
                <span slot="title">导航三</span>
              </el-menu-item>
              <el-menu-item index="4">
                <i class="el-icon-setting"></i>
                <span slot="title">导航四</span>
              </el-menu-item>
            </el-menu>
          </el-col>
        </el-row>
      </el-aside>
      <el-main>Main</el-main>
    </el-container>
  </el-container>
</template>

<script>
  export default {
    name: "main",
    methods: {
      handleOpen(key, keyPath) {
        console.log(key, keyPath);
      },
      handleClose(key, keyPath) {
        console.log(key, keyPath);
      }
    }
  }
</script>

<style lang="scss" scoped>
  .el-header {
    background-color: white;
    box-shadow: 0px 0px 5px #333333;
    color: #333;
    /*text-align: center;*/
    line-height: 60px;
    height: 60px;
  }

  .el-aside {
    background-color: white;
    color: #333;
    /*text-align: center;*/
    /*line-height: 200px;*/
  }

  .el-main {
    background-color: #E9EEF3;
    color: #333;
    text-align: center;
    line-height: 160px;
  }

  .el-container {
    /*margin-bottom: 40px;*/
    /*display: flex;*/
    height: 100%;
    width: 100%;
    /*border: 1px solid #eee;*/
  }
</style>
