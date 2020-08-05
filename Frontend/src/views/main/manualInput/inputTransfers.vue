<template>
  <div>
    <!--面包屑导航区-->
    <el-breadcrumb separator-class="el-icon-arrow-right" style="padding-bottom: 20px">
      <el-breadcrumb-item :to="{ path: '/main' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>手工收入录入</el-breadcrumb-item>
      <el-breadcrumb-item>预存转收入录入</el-breadcrumb-item>
    </el-breadcrumb>
    <el-card>
      <!--查询表单-->
      <el-form ref="form" :model="form" label-width="80px">
        <el-row>
          <el-col :span="11">
            <el-form-item label="城市">
              <el-select style="width: 100%" v-model="form.inCity" filterable placeholder="请选择">
                <el-option
                  v-for="item in optionsCity"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="11">
            <el-form-item label="产品">
              <el-select style="width: 100%" v-model="form.inPro" filterable placeholder="请选择">
                <el-option
                  v-for="item in optionsPro"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="11">
            <el-form-item label="销账类型">
              <el-select style="width: 100%" v-model="form.inType" filterable placeholder="请选择">
                <el-option
                  v-for="item in optionsOut"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="11">
            <el-form-item label="销账日期">
              <el-date-picker v-model="form.inDate" type="date" style="width: 100%" placeholder="选择日期">
              </el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="11">
            <el-form-item label="销账金额">
              <el-input v-model="form.inMoney" placeholder="请输入金额"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <!--按钮区域-->
        <el-form-item>
          <el-col style="display: flex; justify-content: left;">
            <el-button @click="search">查询</el-button>
            <el-button @click="input">录入</el-button>
            <el-button @click="common.exportXLS('预存转收入表', tableData)">导出</el-button>
            <el-button @click="inputXLS">导入</el-button>
            <el-button @click="batchDel">批量删除</el-button>
          </el-col>
        </el-form-item>
        <!--按钮区域结束-->
      </el-form>
      <!--查询表单结束-->
      <!--显示表格-->
      <el-table border style="width: 100%;" max-height="300" :data="tableData">
        <el-table-column type="selection" width="55" header-align="center" align="center"/>
        <el-table-column label="序号" prop="id" width="70" header-align="center" align="center"/>
        <el-table-column label="城市" prop="rpCityCodeT.cityName" header-align="center" align="center"/>
        <el-table-column label="产品" prop="rpProductCodeT.productName" header-align="center" align="center"/>
        <el-table-column label="销账类型" prop="rpWriteOffTypeCodeT.writeOffTypeName" header-align="center" align="center"/>
        <el-table-column label="销账日期" prop="recordDate" header-align="center" align="center"/>
        <el-table-column label="销账金额" prop="writeOffFee" header-align="center" align="center"/>
        <el-table-column label="稽核" prop="checkStatus" header-align="center" align="center"/>
        <el-table-column label="录入人" prop="recordOperator" width="90" header-align="center" align="center"/>
        <el-table-column label="操作" header-align="center" align="center">
          <template slot-scope="scope">
            <el-button :disabled="scope.row.checkStatus==='已通过'?true:false" type="primary" icon="el-icon-edit"
                       @click="editRecord(scope.row)" circle></el-button>
            <el-button :disabled="scope.row.checkStatus==='已通过'?true:false" type="danger" icon="el-icon-delete"
                       @click="delRecord(scope.row)" circle></el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-card>
  </div>
</template>

<script>

  export default {
    name: "inputTransfers",
    data() {
      return {
        form: {
          inCity: '',     // 城市编码
          inPro: '',      // 产品编码
          inType: '',     // 销账类型
          inDate: '',     // 销账日期
          inMoney: '',    // 销账金额
          inPerson: '',   // 录入人
        },
        tableData: [],
        optionsPro: [],
        optionsCity: [],
        optionsOut: [],
      }
    },
    methods: {
      search() {
        //  查询函数
      },
      input() {
        //  录入函数
      },
      batchDel() {
        //  批量删除
      },
      inputXLS() {
        //  从xls导入
      },
      editRecord(row) {
        //  修改记录
      },
      delRecord(row) {
        //  删除记录
      },
      loadInfo() {
        //  加载产品信息
        this.$axios.get('http://localhost:8080/RpProductCodeTController/selectRpProductCodeT').then(res => {
          var tmp = new Array(res.data.length)
          for (var i in res.data) {
            tmp[i] = {}
            tmp[i].value = res.data[i].productCode
            tmp[i].label = res.data[i].productName
          }
          this.optionsPro = tmp
        })
        //  加载城市信息
        this.$axios.get('http://localhost:8080/RpCityCodeT/selectRpCityCodeT').then(res => {
          var tmp = new Array(res.data.length)
          for (var i in res.data) {
            tmp[i] = {}
            tmp[i].value = res.data[i].cityName
            tmp[i].label = res.data[i].cityCode
          }
          this.optionsCity = tmp
        })
        //  加载用户名
        this.$axios.get('http://localhost:8080/RpUserT/getRpUserT?userID=' + sessionStorage.getItem('user'))
          .then(res => {
            this.form.inPerson = res.data.userName
          })
        //  加载销账类型
        this.$axios.get('http://localhost:8080/RpWriteOffTypeCodeT/selectRpWriteOffTypeCodeT').then(res=>{
          var tmp = new Array(res.data.length)
          for (var i in res.data) {
            tmp[i] = {}
            tmp[i].value = res.data[i].writeOffTypeCode
            tmp[i].label = res.data[i].writeOffTypeName
          }
          this.optionsOut = tmp
        })
      },
      loadTable() {
        //  加载表格数据
        this.$axios.get('http://localhost:8080/RpPreFeeRecordT/selectAllRpPreFeeRecordT').then(res => {
          this.tableData = res.data
          console.log(res.data)
        })
      },
    },
    mounted() {
      this.loadInfo()
      this.loadTable()
    }
  }
</script>

<style scoped>

</style>
