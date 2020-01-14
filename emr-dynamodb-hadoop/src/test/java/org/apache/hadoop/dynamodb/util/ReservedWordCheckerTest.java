package org.apache.hadoop.dynamodb.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ReservedWordCheckerTest {
  
  @Test
  public void testIsReservedWord() {
    assertFalse(ReservedWordChecker.isReservedWord("client"));
    assertTrue(ReservedWordChecker.isReservedWord("name"));
    assertTrue(ReservedWordChecker.isReservedWord("client.name"));
    assertTrue(ReservedWordChecker.isReservedWord("client.product.name"));
    assertFalse(ReservedWordChecker.isReservedWord("client.name.product"));
  }
  
  @Test
  public void testEscapeReservedWord() {
    assertEquals("#table_name", ReservedWordChecker.escapeReservedWord("table", "name"));
    assertEquals("#table_client_name", ReservedWordChecker.escapeReservedWord("table", "client.name"));
    assertEquals("#table_client_product_name", ReservedWordChecker.escapeReservedWord("table", "client.product.name"));
  }
}
