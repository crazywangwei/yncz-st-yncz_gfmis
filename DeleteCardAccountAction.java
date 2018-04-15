package gov.gfmis.card.accountmanager.action;

import gov.gfmis.card.accountmanager.ibs.ICardAccountManagerBusiness;
import gov.gfmis.card.common.CardCommonFactory;
import gov.gfmis.fap.util.Global;
import gov.gfmis.pay.common.action.CommonAction;
import gov.gfmis.pay.common.util.PlatformTools;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.util.List;

/**
 * 公务卡开卡行过渡户删除操作
 * @author lgq
 *2016-10-08
 */
public class DeleteCardAccountAction extends CommonAction {

	/**
	 * 串行版本标识Id
	 */
	private static final long serialVersionUID = -6525840942364488430L;
	/**
	 * 业务处理接口
	 */
	private ICardAccountManagerBusiness business = CardCommonFactory.getCardAccountManagerService();

	
	/**
	 * 构造函数
	 */
	public DeleteCardAccountAction() {
		super();
	}
	
	public void realActionPerform(ActionEvent e) {
		List list = this.getPanel().getOperationTable()[0].getSelectedData();
		if(null == list || list.size() == 0) {
			PlatformTools.showSuccessDialog("请选择需要删除的数据!");
			return;
		}
		Global.mainFrame.setCursor(new Cursor(Cursor.WAIT_CURSOR));
		try{
			business.deletePayee(list);
			PlatformTools.showSuccessDialog("删除成功!");
		}catch(Exception e2) {
			PlatformTools.showFailDialog("删除失败："+e2.getMessage());
		}finally {
			Global.mainFrame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}
		this.getPanel().onJumpCurrentPage();
	}

}
