var Button = AMUIReact.Button;
var FormGroup = AMUIReact.FormGroup;
var Input=AMUIReact.Input;
var HeaderForm = React.createClass({
    getInitialState: function () {
    return {
        leftStyle: {display: "none"},
        rightStyle: {display: "none"}
    };
},
render: function () {
    return (
        <div>
        <form className="am-form" target={this.props.urls} method="post">
        <FormGroup>
        <label>网站名：</label>
    <Input type="text" name="title"  placeholder="输入网站名字" radius required />
    </FormGroup>
    <FormGroup>
    <Input type="select" name="classId" label="选择动画">
        <option value="v1">选择动画</option>
        <option value="v1">动画一</option>
        <option value="v2">动画二</option>
        <option value="v3">动画三</option>
        <option value="v4">动画四</option>
        </Input>
        </FormGroup>
        <FormGroup>
        <Button onClick={this.LeftClick} amStyle="primary">点击开启左边菜单</Button>
    <div style={this.state.leftStyle}>
<Input type="text" name="leftLink" placeholder="左边菜单链接" radius  />
<Input type="text" name="leftTitle" placeholder="左边菜单名字" radius  />
<Input type="text" name="leftIcon" placeholder="左边菜单图标" radius  />
<Input type="text" name="leftClassName" placeholder="左边菜单类名" radius  />
</div>
<Button onClick={this.RightClick} amStyle="primary">点击开启右边菜单</Button>
    <div style={this.state.rightStyle}>
<Input type="text" name="rightLink" placeholder="右边菜单链接" radius  />
<Input type="text" name="rightTitle" placeholder="右边菜单名字" radius  />
<Input type="text" name="rightIcon" placeholder="右边菜单图标" radius  />
<Input type="text" name="rightClassName" placeholder="右边菜单类名" radius  />
</div>
</FormGroup>
<FormGroup>
<Input type="text" label="填写主题：" name="theme" placeholder="主题默认default" radius  />
<Input type="select" label="是否固定栏目" name="name">
    <option value="1">固定</option>
    <option value="0">不固定</option>
    </Input>
    </FormGroup>
    <FormGroup>
    <Input type="textarea" label="其他："/>
    </FormGroup>
    <FormGroup>
    <Input type="submit" amStyle="primary" value="提交"  standalone />
<Input type="reset" amStyle="danger" value="重置" standalone />
</FormGroup>
</form>
</div>

);
},
LeftClick: function () {
    if (this.state.leftStyle.display == "none") {
        this.setState({
            leftStyle: {display: "block"}
        });
    } else {
        this.setState({
            leftStyle: {display: "none"}
        });
    }

},
RightClick: function () {
    if (this.state.rightStyle.display == "none") {
        this.setState({
            rightStyle: {display: "block"}
        });
    } else {
        this.setState({
            rightStyle: {display: "none"}
        });
    }
}
});
