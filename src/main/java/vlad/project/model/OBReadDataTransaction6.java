package vlad.project.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * OBReadDataTransaction6
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-11-24T20:00:38.681215900+02:00[Europe/Helsinki]")


public class OBReadDataTransaction6   {
  @JsonProperty("Transaction")
  @Valid
  private List<OBTransaction6> transaction = null;

  public OBReadDataTransaction6 transaction(List<OBTransaction6> transaction) {
    this.transaction = transaction;
    return this;
  }

  public OBReadDataTransaction6 addTransactionItem(OBTransaction6 transactionItem) {
    if (this.transaction == null) {
      this.transaction = new ArrayList<OBTransaction6>();
    }
    this.transaction.add(transactionItem);
    return this;
  }

  /**
   * Get transaction
   * @return transaction
   **/
  @Schema(description = "")
      @Valid
    public List<OBTransaction6> getTransaction() {
    return transaction;
  }

  public void setTransaction(List<OBTransaction6> transaction) {
    this.transaction = transaction;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OBReadDataTransaction6 obReadDataTransaction6 = (OBReadDataTransaction6) o;
    return Objects.equals(this.transaction, obReadDataTransaction6.transaction);
  }

  @Override
  public int hashCode() {
    return Objects.hash(transaction);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OBReadDataTransaction6 {\n");
    
    sb.append("    transaction: ").append(toIndentedString(transaction)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
