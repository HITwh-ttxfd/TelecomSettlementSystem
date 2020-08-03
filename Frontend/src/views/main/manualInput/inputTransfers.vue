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
          <el-col span="11">
            <el-form-item label="城市">
              <!--<el-autocomplete
                popper-class="my-autocomplete"
                v-model="state"
                :fetch-suggestions="querySearch"
                placeholder="请输入.."
                style="width: 100%"
                @select="handleSelect">
                <i
                  class="el-icon-edit el-input__icon"
                  slot="suffix"
                  @click="handleIconClick">
                </i>
                <template slot-scope="{ item }">
                  <div class="name">{{ item.value }}</div>
                  <span class="addr">{{ item.address }}</span>
                </template>
              </el-autocomplete>-->
              <el-select style="width: 100%" v-model="form.inCity" filterable placeholder="请选择">
                <el-option
                  v-for="item in options"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col span="11">
            <el-form-item label="产品">
              <el-select style="width: 100%" v-model="form.inPro" filterable placeholder="请选择">
                <el-option
                  v-for="item in options"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col span="11">
            <el-form-item label="销账类型">
              <el-select style="width: 100%" v-model="form.inType" filterable placeholder="请选择">
                <el-option
                  v-for="item in options"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col span="11">
            <el-form-item label="销账日期">
              <el-date-picker v-model="form.inDate" type="date" style="width: 100%" placeholder="选择日期">
              </el-date-picker>
            </el-form-item>
          </el-col>
          <el-col span="11">
            <el-form-item label="销账金额">
              <el-input v-model="form.inMoney" placeholder="请输入金额"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <!--按钮区域-->
        <el-form-item>
          <el-col style="display: flex; justify-content: left;">
            <el-button>查询</el-button>
            <el-button>录入</el-button>
            <el-button @click="exportXLS">导出</el-button>
            <el-button>导入</el-button>
            <el-button>批量删除</el-button>
          </el-col>
        </el-form-item>
        <!--按钮区域结束-->
      </el-form>
      <!--查询表单结束-->
      <!--显示表格-->
      <el-table border style="width: 100%;" max-height="300" :data="tableData">
        <el-table-column type="selection" width="55" header-align="center" align="center"/>
        <el-table-column label="序号" prop="index" width="70" header-align="center" align="center"/>
        <el-table-column label="城市" prop="city" header-align="center" align="center"/>
        <el-table-column label="产品" prop="product" header-align="center" align="center"/>
        <el-table-column label="销账类型" prop="outType" header-align="center" align="center"/>
        <el-table-column label="销账日期" prop="inMonth" header-align="center" align="center"/>
        <el-table-column label="销账金额" prop="inMoney" header-align="center" align="center"/>
        <el-table-column label="录入人" prop="inPerson" width="90" header-align="center" align="center"/>
        <el-table-column label="操作" header-align="center" align="center">
          <el-button type="primary" icon="el-icon-edit" circle></el-button>
          <el-button type="danger" icon="el-icon-delete" circle></el-button>
        </el-table-column>
      </el-table>
    </el-card>
  </div>
</template>

<script>
  import XLSX from "xlsx";

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
        tableData: [
          {
            index: 1,
            city: '哈尔滨',
            product: '产品A',
            outType: '已出账',
            inMonth: '录入月份',
            inMoney: '录入金额',
            inPerson: '张三',
          },
          {
            index: 1,
            city: '哈尔滨',
            product: '产品A',
            outType: '已出账',
            inMonth: '录入月份',
            inMoney: '录入金额',
            inPerson: '张三',
          },
          {
            index: 1,
            city: '哈尔滨',
            product: '产品A',
            outType: '已出账',
            inMonth: '录入月份',
            inMoney: '录入金额',
            inPerson: '张三',
          },
          {
            index: 1,
            city: '哈尔滨',
            product: '产品A',
            outType: '已出账',
            inMonth: '录入月份',
            inMoney: '录入金额',
            inPerson: '张三',
          }
        ],
        options: [{
          value: '000',
          label: '江西本部'
        }, {
          value: '选项2',
          label: '江西景德镇'
        }, {
          value: '选项3',
          label: '江西南昌'
        }, {
          value: '选项4',
          label: '江西吉安'
        }, {
          value: '选项5',
          label: '北京烤鸭'
        }],
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
      exportXLS() {
        //  导出为xls
        var data = this.tableData
        // const header = {header: ['序号','城市','产品','出账类型','录入月份','录入金额','录入人'] }
        // 空表头参数则直接使用默认Json的表头，声明只能对应
        const header = {header: []}
        var xlsxName = '预存转收入表'
        const ws = XLSX.utils.json_to_sheet(data, header)
        const wb = XLSX.utils.book_new()
        XLSX.utils.book_append_sheet(wb, ws, xlsxName)
        XLSX.writeFile(wb, xlsxName + ".xlsx")
      }
    }
  }
</script>

<style scoped>

</style>
