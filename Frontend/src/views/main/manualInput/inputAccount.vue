<template>
  <div>
    <!--面包屑导航区-->
    <el-breadcrumb separator-class="el-icon-arrow-right" style="padding-bottom: 20px">
      <el-breadcrumb-item :to="{ path: '/main' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>手工收入录入</el-breadcrumb-item>
      <el-breadcrumb-item>出账收入录入</el-breadcrumb-item>
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
            <el-form-item label="出账类型">
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
            <el-form-item label="录入金额">
              <el-input v-model="form.inMoney" placeholder="请输入金额"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <!--按钮区域-->
        <el-form-item>
          <el-col style="display: flex; justify-content: left;">
            <el-button @click="search">查询</el-button>
            <el-button @click="reload">重置</el-button>
            <el-button @click="input">录入</el-button>
            <el-button @click="common.exportXLS('出账收入表', tableData)">导出</el-button>
            <el-button @click="inputXLS">导入</el-button>
            <el-button @click="batchDel">批量删除</el-button>
          </el-col>
        </el-form-item>
        <!--按钮区域结束-->
      </el-form>
      <!--查询表单结束-->
      <!--显示表格-->
      <el-table border style="width: 100%;" max-height="340" :data="tableData"
                @selection-change="handleSelectionChange">

        <el-table-column type="selection" :selectable="selectJudge" width="55" header-align="center" align="center">
        </el-table-column>
        <el-table-column label="序号" prop="id" width="70" header-align="center" align="center"/>
        <el-table-column label="城市" prop="cityCode" width="90" header-align="center" align="center"/>
        <el-table-column label="产品" prop="productCode" width="130" header-align="center" align="center"/>
        <el-table-column label="出账类型" prop="accountFeeTypeCode" width="150" header-align="center" align="center"/>
        <el-table-column label="录入月份" prop="accountRecordMonth" header-align="center" align="center"/>
        <el-table-column label="录入金额" prop="accountFee" header-align="center" align="center"/>
        <el-table-column label="稽核" prop="checkStatus" header-align="center" align="center"/>
        <el-table-column label="录入人" prop="accountOperator" width="90" header-align="center" align="center"/>
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
    <el-dialog
      title="修改记录"
      :visible.sync="centerDialogVisible"
      width="50%"
      center>
      <el-form ref="form" :model="form" label-width="80px">
        <el-row>
          <el-col :span="11">
            <el-form-item label="城市">
              <el-select style="width: 100%" v-model="editIndex.cityCode" filterable placeholder="请选择">
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
              <el-select style="width: 100%" v-model="editIndex.productCode" filterable placeholder="请选择">
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
            <el-form-item label="出账类型">
              <el-select style="width: 100%" v-model="editIndex.accountFeeTypeCode" filterable placeholder="请选择">
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
            <el-form-item label="录入金额">
              <el-input v-model="editIndex.accountFee" placeholder="请输入金额"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="11">
            <el-form-item label="录入月份">
              <el-date-picker v-model="editIndex.accountRecordMonth" type="date" style="width: 100%" placeholder="选择日期">
              </el-date-picker>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <span slot="footer" class="dialog-footer">
    <el-button @click="centerDialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="confirmEdit">确 定</el-button>
  </span>
    </el-dialog>
  </div>
</template>

<script>

  export default {
    name: "inputAccount",
    data() {
      return {
        form: {
          inCity: '',   // 城市编码
          inPro: '',    // 产品编码
          inType: '',   // 出账类型
          inMoney: '',  // 录入金额
          inDate: '',   // 录入时间
          inPerson: '', // 录入人
        },
        tableData: [],
        check: false,
        optionsPro: [],
        optionsCity: [],
        optionsOut: [],
        delList: [],
        centerDialogVisible: false,
        editIndex: {}
      }
    },
    methods: {
      search() {
        //  查询函数
      },
      input() {
        //  录入函数
        var data = this.form
        if (data.inCity === '' || data.inPro === '' || data.inType === '' || data.inMoney === '') {
          // console.log(data)
          this.$message.error('请将录入项都补充完整')
          return
        }
        data.inDate = this.common.getNowTime().substring(0, 10)
        this.$axios.get('http://localhost:8080/RpAccountFeeRecordT/createRpAccountFeeRecordT/' +
          '?cityCode=' + data.inCity + '&productCode=' + data.inPro + '&accountFeeTypeCode=' + data.inType +
          '&accountRecordMonttemp=' + data.inDate + '&accountFee=' + data.inMoney + '&accountOperator=' + data.inPerson)
          .then(res => {
            this.$message.success('录入信息成功！')
            this.reload()
          })
      },
      reload() {
        //  重置页面
        this.form.inMoney = ''
        this.form.inType = ''
        this.form.inPro = ''
        this.form.inCity = ''
        this.loadInfo()
        this.loadTable()
      },
      batchDel() {
        //  批量删除
        if (this.delList.length === 0) {
          this.$message.warning('请选择要删除的记录.')
          return
        }
        var url = 'http://localhost:8080/RpAccountFeeRecordT/deleteRpNetBalanceRecordT/?ids='
        for (var i in this.delList) {
          url = url + this.delList[i].id
          if (i < (this.delList.length - 1)) {
            url = url + ','
          }
        }
        this.$axios.get(url).then(res => {
          this.$message.success('删除记录成功！')
          this.delList = []
          this.reload()
        })
      },
      inputXLS() {
        //  导入xls
      },
      editRecord(row) {
        //  修改记录
        this.centerDialogVisible = true
        this.editIndex = row
        console.log(this.editIndex)
      },
      handleSelectionChange(val) {
        //  选中表格事件 val表示选中的元组数组
        this.delList = val
      },
      delRecord(row) {
        //  删除记录
        this.$axios.get('http://localhost:8080/RpAccountFeeRecordT/deleteRpNetBalanceRecordT/?ids=' + row.id)
          .then(res => {
            this.$message.success('删除记录成功！')
            this.loadTable()
          })
      },
      loadInfo() {
        //  加载信息
        //  加载产品信息
        this.$axios.get('http://localhost:8080/RpProductCodeTController/selectRpProductCodeT').then(res => {
          var tmp = new Array(res.data.length)
          for (var i in res.data) {
            tmp[i] = {}
            tmp[i].value = res.data[i].productCode
            tmp[i].label = res.data[i].productName
          }
          this.optionsPro = tmp
          // console.log(tmp)
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
        //  加载出账类型信息
        this.$axios.get('http://localhost:8080/RpAccountTypeCodeT/selectRpAccountTypeCodeT').then(res => {
          var tmp = new Array(res.data.length)
          for (var i in res.data) {
            tmp[i] = {}
            tmp[i].value = res.data[i].accountTypeCode
            tmp[i].label = res.data[i].accountTypeName
          }
          this.optionsOut = tmp
        })
        //  加载用户名
        this.$axios.get('http://localhost:8080/RpUserT/getRpUserT?userID=' + sessionStorage.getItem('user'))
          .then(res => {
            this.form.inPerson = res.data.userName
            // console.log(this.form)
          })
      },
      loadTable() {
        //  加载表格信息
        this.$axios.get('http://localhost:8080/RpAccountFeeRecordT/getAllRpAccountFeeRecordT').then(res => {
          // console.log(res.data)
          this.tableData = res.data
          for (var i in this.tableData) {
            this.tableData[i].accountRecordMonth = this.tableData[i].accountRecordMonth.substring(0, 10)
          }
        })
      },
      selectJudge(row, index) {
        //  可选择判断
        if (row.checkStatus === '已通过')
          return false
        else
          return true
      },
      confirmEdit(){
        //  编辑记录提交
        this.centerDialogVisible = false
        console.log(this.editIndex)
      }
    },
    mounted() {
      this.loadInfo()
      this.loadTable()
    }
  }
</script>

<style scoped>


</style>
