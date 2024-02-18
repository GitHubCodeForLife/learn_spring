package chubb.com.beans.factory_bean;

public class Tool {
    private int toolId;
    public Tool(int toolId) {
        this.toolId = toolId;
    }

    public int getToolId() {
        return toolId;
    }

    public void setToolId(int toolId) {
        this.toolId = toolId;
    }

    @Override
    public String toString() {
        return "Tool{" +
                "toolId=" + toolId +
                '}';
    }
}
