<template>
  <div>
    <!--面包屑导航区-->
    <el-breadcrumb separator-class="el-icon-arrow-right" style="padding-bottom: 20px">
      <el-breadcrumb-item :to="{ path: '/main' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>手工收入录入</el-breadcrumb-item>
      <el-breadcrumb-item>网间结算收入录入</el-breadcrumb-item>
    </el-breadcrumb>
    <el-card>
      <!--查询表单-->
      <el-form ref="form" :model="form" label-width="80px">
        <el-row>
          <el-col :span="11">
            <el-form-item label="城市" label-width="90px">
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
            <el-form-item label="结算运营商" label-width="90px">
              <el-select style="width: 100%" v-model="form.inOrg" filterable placeholder="请选择">
                <el-option
                  v-for="item in optionsSp"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="11">
            <el-form-item label="结算类型">
              <el-select style="width: 100%" v-model="form.inType" filterable placeholder="请选择">
                <el-option
                  v-for="item in optionsBal"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="11">
            <el-form-item label="结算日期" label-width="90px">
              <el-date-picker v-model="form.inDate" type="date" style="width: 100%"
                              value-format="yyyy-MM-dd" placeholder="选择日期">
              </el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="11">
            <el-form-item label="结算金额">
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
            <el-button @click="common.exportXLS('网间收入表', tableData)">导出</el-button>
            <el-button @click="inputXLS">导入</el-button>
            <el-button @click="batchDel">批量删除</el-button>
          </el-col>
        </el-form-item>
        <!--按钮区域结束-->
      </el-form>
      <!--查询表单结束-->
      <!--显示表格-->
      <el-table border style="width: 100%;" max-height="270" :data="tableData"
                @selection-change="handleSelectionChange">
        <el-table-column type="selection" :selectable="selectJudge" width="55" header-align="center" align="center"/>
        <el-table-column label="序号" prop="id" width="70" header-align="center" align="center"/>
        <el-table-column label="城市" prop="rpCityCodeT.cityName" header-align="center" align="center"/>
        <el-table-column label="产品" prop="rpProductCodeT.productName" width="150" header-align="center" align="center"/>
        <el-table-column label="结算运营商" prop="rpBalanceSpCodeT.balanceSpName" header-align="center" align="center"/>
        <el-table-column label="结算类型" prop="rpBalanceTypeCodeT.balanceTypeName" header-align="center" align="center"/>
        <el-table-column label="结算金额" prop="balanceFee" header-align="center" align="center"/>
        <el-table-column label="结算日期" prop="balanceMonth" header-align="center" align="center"/>
        <el-table-column label="稽核" prop="checkStatus" header-align="center" align="center"/>
        <el-table-column label="录入人" prop="recordOperator" width="90" header-align="center" align="center"/>
        <el-table-column label="操作" width="120" header-align="center" align="center">
          <template slot-scope="scope">
            <el-button :disabled="scope.row.checkStatus==='已通过'?true:false" type="primary" icon="el-icon-edit"
                       @click="editRecord(scope.row)" circle></el-button>
            <el-button :disabled="scope.row.checkStatus==='已通过'?true:false" type="danger" icon="el-icon-delete"
                       @click="delRecord(scope.row)" circle></el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-card>
    <!--修改弹窗-->
    <el-dialog
      :title="logTitle"
      :visible.sync="centerDialogVisible"
      width="50%"
      center>
      <el-form ref="form" :model="editIndex" label-width="100px">
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
              <!--.productName-->
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
          <el-col :span="11">
            <el-form-item label="结算运营商">
              <el-select style="width: 100%" v-model="editIndex.balanceSpCode" filterable placeholder="请选择">
                <el-option
                  v-for="item in optionsSp"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="11">
            <el-form-item label="结算类型">
              <el-select style="width: 100%" v-model="editIndex.balanceTypeCode" filterable placeholder="请选择">
                <el-option
                  v-for="item in optionsBal"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="11">
            <el-form-item label="结算日期">
              <el-date-picker v-model="editIndex.balanceMonth" type="date" style="width: 100%"
                              value-format="yyyy-MM-dd" placeholder="选择日期">
              </el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="11">
            <el-form-item label="结算金额">
              <el-input :disabled="check2" v-model="editIndex.balanceFee" placeholder="请输入金额"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="11">
            <el-form-item label="序号">
              <el-input :disabled="check||check2" v-model="editIndex.id" placeholder="请输入序号"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="11">
            <el-form-item label="录入人">
              <el-input :disabled="check||check2" v-model="editIndex.recordOperator" placeholder="请输入录入人"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="11">
            <el-form-item label="稽核">
              <el-input :disabled="check||check2" v-model="editIndex.checkStatus" placeholder="请输入稽核状态"></el-input>
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
    name: "inputInternet",
    data() {
      return {
        form: {
          inCity: '',       // 城市编码
          inPro: '',        // 产品编码
          inOrg: '',        // 结算运营商
          inType: '',       // 结算类型
          inDate: '',       // 结算日期
          inMoney: '',      // 结算金额
          inPerson: '',     // 录入人
        },
        tableData: [],
        optionsPro: [],
        optionsCity: [],
        optionsSp: [],
        optionsBal: [],
        delList: [],
        logTitle: '',
        check: false,
        check2: false,
        centerDialogVisible: false,
        editIndex: {},
      }
    },
    methods: {
      search() {
        //  查询函数
        this.check = false
        this.check2 = true
        this.editIndex = {}
        this.logTitle = '查询记录'
        this.centerDialogVisible = true
      },
      input() {
        //  录入函数
        var data = this.form
        // data.inDate = this.common.getNowTime().substring(0, 10)
        // data.inDate = this.common.getNowTime()
        for (var i in data) {
          if (data[i] === '') {
            this.$message.error('请将录入项都补充完整')
            return
          }
        }
        this.$axios.get('http://localhost:8080/RpNetBalanceRecordT/addRpNetBalanceRecordT?' +
          'cityCode=' + data.inCity + '&productCode=' + data.inPro + '&balanceMonth=' + data.inDate +
          '&balanceSpCode=' + data.inOrg + '&balanceTypeCode=' + data.inType +
          '&recordOperator=' + data.inPerson + '&balanceFee=' + data.inMoney).then(res => {
          this.$message.success('录入记录成功！')
          this.reload()
        })
      },
      batchDel() {
        //  批量删除
        if (this.delList.length === 0) {
          this.$message.warning('请选择要删除的记录.')
          return
        }
        var url = 'http://localhost:8080/RpNetBalanceRecordT/deleteRpNetBalanceRecordT?ids='
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
        //  从xls导入
      },
      editRecord(row) {
        //  修改记录
        this.logTitle = '修改记录'
        this.editIndex = row
        // console.log(this.editIndex)
        this.editIndex.balanceTypeCode = this.editIndex.rpBalanceTypeCodeT.balanceTypeName
        this.editIndex.balanceSpCode = this.editIndex.rpBalanceSpCodeT.balanceSpName
        this.editIndex.cityCode = this.editIndex.rpCityCodeT.cityName
        this.editIndex.productCode = this.editIndex.rpProductCodeT.productName
        this.check = true
        this.centerDialogVisible = true
      },
      delRecord(row) {
        //  删除记录
        this.$axios.get('http://localhost:8080/RpPreFeeRecordT/deleteRpPreFeeRecordT?ids=' + row.id)
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
        //  运营商类型
        this.$axios.get('http://localhost:8080/RpBalanceSpCodeT/selectRpBalanceSpCodeT').then(res => {
          var tmp = new Array(res.data.length)
          for (var i in res.data) {
            tmp[i] = {}
            tmp[i].value = res.data[i].balanceSpCode
            tmp[i].label = res.data[i].balanceSpName
          }
          this.optionsSp = tmp
        })
        //  结算类型
        this.$axios.get('http://localhost:8080/RpBalanceTypeCodeT/selectRpBalanceTypeCodeT').then(res => {
          var tmp = new Array(res.data.length)
          for (var i in res.data) {
            tmp[i] = {}
            tmp[i].value = res.data[i].balanceTypeCode
            tmp[i].label = res.data[i].balanceTypeName
          }
          this.optionsBal = tmp
        })
        //  加载用户名
        this.$axios.get('http://localhost:8080/RpUserT/getRpUserT?userID=' + sessionStorage.getItem('user'))
          .then(res => {
            this.form.inPerson = res.data.userName
          })
      },
      loadTable() {
        //  加载表格信息
        this.$axios.get('http://localhost:8080/RpNetBalanceRecordT/selectAllRpNetBalanceRecordT').then(res => {
          // console.log(res)
          this.tableData = res.data
        })
      },
      reload() {
        for(var i in this.form){
          this.form[i] = ''
        }
        this.loadTable()
        this.loadInfo()
      },
      handleSelectionChange(val) {
        //  选中表格事件 val表示选中的元组数组
        this.delList = val
      },
      selectJudge(row, index) {
        //  可选择判断
        if (row.checkStatus === '已通过')
          return false
        else
          return true
      },
      confirmEdit() {
        //  弹窗提交
        if (this.check) {
          //  修改记录
          //  修改为编码
          for (var i in this.optionsCity) {
            if (this.editIndex.cityCode === this.optionsCity[i].label) {
              this.editIndex.cityCode = this.optionsCity[i].value
              break
            }
          }
          for (var i in this.optionsPro) {
            if (this.editIndex.productCode === this.optionsPro[i].label) {
              this.editIndex.productCode = this.optionsPro[i].value
              break
            }
          }
          for (var i in this.optionsSp) {
            if (this.editIndex.balanceSpCode === this.optionsSp[i].label) {
              this.editIndex.balanceSpCode = this.optionsSp[i].value
              break
            }
          }
          for (var i in this.optionsBal) {
            if (this.editIndex.balanceTypeCode === this.optionsBal[i].label) {
              this.editIndex.balanceTypeCode = this.optionsBal[i].value
              break
            }
          }
          console.log(this.editIndex)
          this.$axios.get('http://localhost:8080/RpNetBalanceRecordT/updateRpNetBalanceRecordT?' +
            'ID=' + this.editIndex.id + '&cityCode=' + this.editIndex.cityCode + '&productCode=' + this.editIndex.productCode +
            '&balanceMonth=' + this.editIndex.balanceMonth + '&balanceSpCode=' + this.editIndex.balanceSpCode +
            '&balanceTypeCode=' + this.editIndex.balanceTypeCode + '&recordOperator=' + this.editIndex.recordOperator +
            '&checkStatus=' + this.editIndex.checkStatus + '&balanceFee=' + this.editIndex.balanceFee).then(res => {
            this.$message.success('修改记录成功！')
            this.reload()
          })
        } else {
          //  查询记录
          var url = 'http://localhost:8080/RpNetBalanceRecordT/selectAllRpNetBalanceRecordT?'
          for (var i in this.editIndex) {
            if (i === 'id') {
              url = url + 'ID' + '=' + this.editIndex[i] + '&'
            } else {
              url = url + i + '=' + this.editIndex[i] + '&'
            }
          }
          url = url.substring(0, url.length - 1)
          this.$axios.get(url).then(res => {
            // console.log(res)
            if (res.data.length === 0) {
              this.$message.warning('未查询到符合条件的记录.')
              this.reload()
            } else {
              this.$message.success('查询记录成功！')
              this.tableData = res.data
            }
          })
        }
        this.centerDialogVisible = false
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
