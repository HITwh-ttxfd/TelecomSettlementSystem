<template>
  <div>
    <!--面包屑导航区-->
    <el-breadcrumb separator-class="el-icon-arrow-right" style="padding-bottom: 20px">
      <el-breadcrumb-item :to="{ path: '/main' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>个人信息</el-breadcrumb-item>
    </el-breadcrumb>
    <el-card>
      <div class="outerDiv">
        <p style="font-size: 30px">欢迎，{{userInfo.userName}}</p>
      </div>
      <el-divider><i class="el-icon-user"></i></el-divider>
      <div class="infoDiv">
        <div class="textDiv">
          <el-row>
            <!--左边栏-->
            <el-col :span="7" style="text-align: left; line-height: 50px;">
              <el-col>
                编号：{{userInfo.userID}}
              </el-col>
              <el-col>
                用户名：{{userInfo.userName}}
              </el-col>
              <el-col>
                部门：{{userInfo.dept}}
              </el-col>
              <el-col>
                地区：{{userInfo.locationNo}}
              </el-col>
              <el-col>
                权限：{{userInfo.eRight}}
              </el-col>
              <el-col>
                查询特权：{{userInfo.vipRight}}
              </el-col>
            </el-col>
            <!--右边栏-->
            <el-col :span="7" style="text-align: left; line-height: 50px; padding-left: 0px">
              <el-col>
                姓名：{{userInfo.trueName}}
              </el-col>
              <el-col>
                性别：{{userInfo.sex}}
              </el-col>
              <el-col>
                年龄：{{userInfo.age}}
              </el-col>
              <el-col>
                邮箱：{{userInfo.email}}
              </el-col>
            </el-col>
            <el-col :span="10" style="padding-right: 10px; position: relative; right: 4%">
              <el-image :src="imgurl"></el-image>
            </el-col>
          </el-row>
        </div>
        <!--<div style="background-color: gainsboro; height: 410px; width: 4px; position: relative; left: 49.84%">
        </div>-->
      </div>
    </el-card>
  </div>
</template>

<script>
  export default {
    name: "userInfo",
    data() {
      return {
        userInfo: {
          userID: '',     //编号
          userName: '',   //用户名
          passWord: '',   //密码
          trueName: '',   //姓名
          sex: '',        //性别
          age: '',        //年龄
          eRight: '',     //角色权限 需转换
          locationNo: '', //所属地区编号 需转换
          dept: '',       //所属部门
          email: '',      //邮箱
          vipRight: ''    //查询特权 需转换
        },
        imgurl: 'http://39.98.48.34:2233/userImg/userinfo.png'
      }
    }
  }
</script>

<style scoped>
  .outerDiv {
    display: flex;
    justify-content: left;
    padding-left: 50px;
  }

  .infoDiv {
    /*background-color: antiquewhite;*/
    height: 370px;
  }

  .textDiv {
    display: flex;
    justify-content: left;
    font-size: 18px;
    padding-left: 30px;
    padding-top: 40px
  }
</style>
