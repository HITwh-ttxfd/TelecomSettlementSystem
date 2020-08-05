<template>
  <div class="login-wrap">
    <div class="ms-login">
      <div class="ms-title">电信结算系统</div>
      <el-form :model="param" :rules="rules" ref="login" label-width="0px" class="ms-content">
        <el-form-item prop="username">
          <el-input v-model="param.username" placeholder="请输入用户名" @keyup.enter.native="submitForm()">
            <el-button slot="prepend" icon="el-icon-user"/>
          </el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input
            type="password"
            placeholder="请输入密码"
            v-model="param.password"
            show-password
            @keyup.enter.native="submitForm()">
            <el-button slot="prepend" icon="el-icon-lock"/>
          </el-input>
        </el-form-item>
        <div class="btn">
          <el-button type="success" @click="submitForm()">登录</el-button>
        </div>
      </el-form>
    </div>
  </div>
</template>

<script>
  export default {
    data: function () {
      return {
        dialogFormVisible: false,
        formLabelWidth: '70px',
        registration: {
          username: '',
          password: '',
          name: '',
          phoneNumber: '',
          id: '',
          radio: ''
        },
        param: {
          username: '',
          password: '',
        },
        rules: {
          username: [{required: true, message: '请输入用户名', trigger: 'blur'}],
          password: [{required: true, message: '请输入密码', trigger: 'blur'}],
        }
      };
    },
    methods: {
      submitForm() {
        this.$refs.login.validate((valid) => {
          if (valid) {
            this.$axios({
              method: 'GET',
              url: 'http://localhost:8080/RpUserT/loginRpUserT',
              params: {
                userID: this.param.username,
                passWord: this.param.password
              }
            }).then(res => {
              if (res.data === 1) {
                sessionStorage.user = this.param.username;
                this.$axios({
                  method: 'GET',
                  url: 'http://localhost:8080/RpUserT/roleRight',
                  params: {
                    userID: sessionStorage.user
                  }
                }).then(res => {
                  this.$message.success('登录成功');
                  sessionStorage.auth = res.data;
                  //  加载用户名
                  this.$axios.get('http://localhost:8080/RpUserT/getRpUserT?userID=' + sessionStorage.getItem('user'))
                    .then(res => {
                      sessionStorage.name = res.data.userName
                    })
                  this.$router.push('/center');
                }).catch(e => {
                  this.$message.error('预期之外的错误');
                })
              } else
                this.$message.error('用户名或密码错误');
            }).catch(e => {
              this.$message.error('无法连接至服务器');
            })
          } else {
            this.$message.error('请输入用户名密码');
          }
        });
      },
    },
  };
</script>

<style scoped>
  .login-wrap {
    position: relative;
    width: 100%;
    height: 100%;
    background-size: 100%;
    background: url("../../assets/725413ef4836c6415e9e481dcbecb964.jpg") no-repeat center;
    background-size: cover;
  }

  .ms-title {
    width: 100%;
    line-height: 50px;
    text-align: center;
    font-size: 20px;
    color: #fff;
    border-bottom: 1px solid #dddddd;
  }

  .ms-login {
    position: absolute;
    left: 50%;
    top: 50%;
    width: 350px;
    margin: -190px 0 0 -175px;
    border-radius: 5px;
    background: rgba(175, 176, 177, 0.75);
    overflow: hidden;
  }

  .ms-content {
    padding: 30px 30px;
    text-align: center;
  }

  .btn {
    text-align: center;
  }

  .btn button {
    width: 100%;
    height: 36px;
    margin-bottom: 10px;
  }

  .el-dialog {
    width: 30%;
  }

  .el-dialog .el-form-item {
    margin-left: 5%;
    width: 60%;
  }

  .el-dialog {
    /*float: left;*/
    text-align: center;
  }

  .el-dialog .radio {
    margin-right: 30%;
  }
</style>
