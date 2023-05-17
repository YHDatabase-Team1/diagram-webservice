package yhdatabase.datamodule.domain;

import lombok.Getter;
import lombok.Setter;
import org.json.JSONArray;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ProgWorkFlowMng {
    private Long flowId;

    private Long progId;

    private int flowSeq;

    private String flowType;

    private JSONObject flowAttr;

    private String flowDesc;

    private LocalDateTime crtdDttm;

    private LocalDateTime updtdttm;

    private LocalDateTime dltDttm;

    public ProgWorkFlowMng(Long flowId, Long progId, int flowSeq, String flowType, JSONObject flowAttr,
                           String flowDesc, LocalDateTime crtdDttm, LocalDateTime updtdttm, LocalDateTime dltDttm) {

        this.flowId = flowId;
        this.progId = progId;
        this.flowSeq = flowSeq;
        this.flowType = flowType;
        this.flowAttr = flowAttr;
        this.flowDesc = flowDesc;
        this.crtdDttm = crtdDttm;
        this.updtdttm = updtdttm;
        this.dltDttm = dltDttm;
    }

    public ProgWorkFlowMng() {
    }
    
    //sql 없는 예외 사항 구현 해야함
    public String findSql() {
        return this.flowAttr.getString("sql");
    }

    public List<String> findColInfo() {
        List<String> colList = new ArrayList<>();

        JSONArray colJsonArray = (JSONArray) this.flowAttr.get("col_info");

        for(Object s : colJsonArray) {
            colList.add(s.toString());
        }

        return colList;
    }
}
